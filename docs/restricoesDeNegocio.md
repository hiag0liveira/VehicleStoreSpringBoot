# Restrições e Regras de Negócio
* Para cadastrar um carro é preciso preencher todos os campos.

* No cadastro da concessionaria tem que ser atribuido um whatsapp  e um endereço.

* Todos os vendedores tem que fazer o login no sistema para atendimento.

* O cliente pode se cadastrar e usando um chat ou inicializando a convesa via whatsapp.

* Para poder dar um feedback ou fazer um agendamento o cliente deve esta logado.

* Será permitido alteração  dos dados no futuro

### Whatsapp
* Telefone - varchar(11) not null

### Concessionaria
* Nome - varchar(50) not null
* CNPJ - Padrão (regex)-> Formato específico. not null

### Carro
* Nome - varchar(50) not null
* Marca - varchar(20) not null
* Modelo - varchar(50) not null
* Combustivel - Enum ( TipoCombustivelEnum) not null
* Cor - varchar(50) not null 
* Placa - varchar(10) not null
* Km - varchar(10) not null
* AnoFabricacao - int not null
* AnoModelo - int not null
* Descricao - varchar(50) 

### Endereco
* Rua - varchar(50) not null
* Numero - int not null
* Cep - varchar(8)
* Complemento - varchar(50)
* Cidade - varchar(50) not null
* Bairro - varchar(50)

### Pessoa
* Nome - varchar(50) not null
* CPF - Padrão (regex)-> Formato específico. not null
* CodUser - int auto_increment
* E-mail - varchar(50) not null
* Telefone - varchar(11) not null
* Senha - varchar(50) not null

### Vendedor 
* Cargo - varchar(50) not null

### Agendamento
* Data - date not null
* hora - varchar(5) not null

### FeedBack
* Assunto - varchar(50) not null
* Data - date
