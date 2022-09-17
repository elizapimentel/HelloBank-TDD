INSERT INTO cliente (nome, email, cpf, registro_geral, data_nascimento, telefone, estado, cidade, cep)
VALUES ('João da Silva', 'john@test.com', '12345678901', '123456789', '01/01/1990', '11999999999', 'SP', 'São Paulo', '00000000');

INSERT INTO cliente (nome, email, cpf, registro_geral, data_nascimento, telefone, estado, cidade, cep)
VALUES ('Maria da Silva', 'mary@test.com', '12345678902', '123456780', '01/01/1990', '11999999999', 'SP', 'São Paulo', '00000000');

INSERT INTO conta (id_cliente, num_conta, saldo)
VALUES (1, '12345678', 1000.00);

INSERT INTO conta (id_cliente, num_conta, saldo)
VALUES (2, '12345679', 1000.00);