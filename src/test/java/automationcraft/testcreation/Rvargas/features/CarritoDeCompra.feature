Feature: Carrito de Compra
  Como usuario
  quiero poder agregar productos al carrito
  para hacer una compra online de productos

  Background: Agregar producto
    Given que estoy en la url "https://www.paris.cl/iphone-11-64gb-negro%C2%A0%C2%A0-486146999.html#q=iphone&start=1"
    When presiono el boton guardar
    Then se debe agregar correctamente el producto al carrito
    And ver el carrito de compra en pantalla

  Scenario: CA-01 - Límite de Stock de un producto
    Given que el cliente está el en carrito de compras con al menos 1 producto
    When el cliente aumenta la cantidad a pedir del producto a un número mayor de 20
    And hace clic en "Actualizar la Compra"
    Then se debe mostrar un popup que dice "Atención Has excedido el número máximo de unidades que puedes solicitar."
