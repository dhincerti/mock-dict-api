# mock-dict-api
Mock da API de Diretório de Identificadores de Contas Transacionais (DICT), parte fundamental do sistema de Pagamento Instantâneo (PIX) desenvolvido pelo Banco Central

Veja os projetos originais do BC em: 
- [DICT - API](https://github.com/bacen/pix-dict-api)
- [DICT - QuickStart](https://github.com/bacen/pix-dict-quickstart)

Documentação oficial:
- [Pagamentos instantâneos](https://www.bcb.gov.br/estabilidadefinanceira/pagamentosinstantaneos)
- [Fórum PI – Reuniões e Documentos](https://www.bcb.gov.br/estabilidadefinanceira/forumpagamentosinstantaneos) 

### Dependências
- Java 11
- Maven

### Como rodar este projeto
- Clone ou faça o download: `git clone git@github.com:dhincerti/mock-dict-api.git`
- Rode o comando: `mvn spring-boot:run`

### Exemplos
#### Criar Vínculo 
```
curl --location --request POST 'http://localhost:9000/api/v1/entries' \
--header 'Content-Type: application/xml' \
--data-raw '<?xml version="1.0" encoding="UTF-8"?>
<CreateEntryRequest>
  <Signature>ASSINATURA123</Signature>
  <Entry>
    <Key>+5561988887777</Key>
    <KeyType>PHONE</KeyType>
    <Account>
      <Participant>12345678</Participant>
      <Branch>00001</Branch>
      <AccountNumber>0007654321</AccountNumber>
      <AccountType>CACC</AccountType>
    </Account>
    <Owner>
      <Type>NATURAL_PERSON</Type>
      <TaxIdNumber>11122233300</TaxIdNumber>
      <Name>João Silva</Name>
    </Owner>
  </Entry>
</CreateEntryRequest>```