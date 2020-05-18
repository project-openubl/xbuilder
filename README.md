![CI](https://github.com/project-openubl/xml-builder-lib/workflows/CI/badge.svg)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=project-openubl_xml-builder-lib&metric=alert_status)](https://sonarcloud.io/dashboard?id=project-openubl_xml-builder-lib)
[![FOSSA Status](https://app.fossa.com/api/projects/git%2Bgithub.com%2Fcarlosthe19916%2Fxml-builder-lib.svg?type=shield)](https://app.fossa.com/projects/git%2Bgithub.com%2Fcarlosthe19916%2Fxml-builder-lib?ref=badge_shield)

# XML Builder Library

Java library for creating XML files based on UBL standards.

## Supported countries

- Perú

> If you want support for your country please create an issue.

## Getting started

XML files can be created from Input Models; for instance:

```java
InvoiceInputModel input = InvoiceInputModel.Builder.anInvoiceInputModel()
                .withSerie("F001")
                .withNumero(1)
                .withProveedor(ProveedorInputModel.Builder.aProveedorInputModel()
                        .withRuc("12345678912")
                        .withRazonSocial("Softgreen S.A.C.")
                        .build()
                )
                .withCliente(ClienteInputModel.Builder.aClienteInputModel()
                        .withNombre("Carlos Feria")
                        .withNumeroDocumentoIdentidad("12121212121")
                        .withTipoDocumentoIdentidad(Catalog6.RUC.toString())
                        .build()
                )
                .withDetalle(Arrays.asList(
                        DocumentLineInputModel.Builder.aDocumentLineInputModel()
                                .withDescripcion("Item1")
                                .withCantidad(new BigDecimal(10))
                                .withPrecioUnitario(new BigDecimal(100))
                                .withUnidadMedida("KGM")
                                .build(),
                        DocumentLineInputModel.Builder.aDocumentLineInputModel()
                                .withDescripcion("Item2")
                                .withCantidad(new BigDecimal(10))
                                .withPrecioUnitario(new BigDecimal(100))
                                .withUnidadMedida("KGM")
                                .build())
                )
                .build();

// Process Input and get XML
DocumentWrapper<InvoiceOutputModel> result = DocumentFacade.createXML(input, config, systemClock);
InvoiceOutputModel output = result.getOutput();
String xml = result.getXml();
```

## Sign XMLs

After you created the `xml` file you can now sign it:

```java
String xml;
String signID = "mySignID";

// Get your certificate using the method of your preference
X509Certificate certificate;
PrivateKey privateKey;

Document signedXML = XMLSigner.signXML(xml, signID, certificate, privateKey);
```
