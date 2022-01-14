package api_testing.rvargas;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.equalTo;

public class covid19_datos_validos {

    //variables del encabezado
    String key,host;

    //parametros
    String date,name;

    //EndPoint
    String url;

    @Before
    public void init() {
        baseURI = "https://covid-19-data.p.rapidapi.com";

        //parametros
        this.date = "2020-04-01";
        this.name = "USA";

        //encabezados
        this.key = "65c3a8ec1emsh38db88917d7c333p1cd20ajsn923976797f86";
        this.host = "covid-19-data.p.rapidapi.com";

        this.url = "/report/country/name";

    }

    @Test
    public void ATC_Impresion_JSON()
    {
        String JSON = given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("date",this.date).
                param("name", this.name).
                get(url).asPrettyString();

        System.out.println(JSON);
    }

    @Test
    public void ATC_Codigo_200()
    {
        given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("date",this.date).
                param("name", this.name).
                when().
                get(url).
                then().assertThat().statusCode(200);

    }

    /*
    ID:ATC001 UbicacionInicial
    Descripcion: La propiedad 'Country' devuelve 'USA'
    */
    @Test

    public void ATC_001_UbicacionInicial()
    {
        given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("date",this.date).
                param("name", this.name).
                when().
                get(url).
                then().
                assertThat().statusCode(200).
                body("country[0]",equalTo("USA"));

    }

    /*
    ID:ATC001 Valor
    Descripcion: La propiedad 'province' devuelve 'Alaska'
    */
    @Test
    public void ATC_002_Valor()
    {
        given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("date",this.date).
                param("name", this.name).
                when().
                get(url).
                then().
                assertThat().statusCode(200).
                body("provinces[0].province[1]",equalTo("Alaska"));

    }


    @Test
    public void ATC_Estructura() {
        File file = new File("src/test/java/api_testing/rvargas/covid19-schema.json");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        given().header("x-rapidapi-key", this.key).
                and().header("x-rapidapi-host", this.host).
                param("date", this.date).
                param("name", this.name).
                when().
                get(url).
                then().
                assertThat().body(matchesJsonSchema(fileInputStream));
    }

}