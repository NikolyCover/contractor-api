SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE installment;
TRUNCATE TABLE contract;
TRUNCATE TABLE contract_item;
TRUNCATE TABLE contracted_company;
TRUNCATE TABLE contracted_company_employee;
TRUNCATE TABLE contract_type;
TRUNCATE TABLE hiring_company;
TRUNCATE TABLE hiring_company_employee;
TRUNCATE TABLE payment_method;

SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO hiring_company (name, corporate_name, code, phone, email, address, matrix)
VALUES
    ('Tech Solutions Ltda', 'Tech Solutions Tecnologia da Informação Ltda', 'TS123456', '11-98765-4321', 'contato@techsolutions.com.br', 'Rua das Inovações, 100, São Paulo, SP', true),
    ('Global Services SA', 'Global Serviços SA', 'GS654321', '21-99876-5432', 'admin@globalservices.com.br', 'Av. Internacional, 200, Rio de Janeiro, RJ', false),
    ('Creative Industries LTDA', 'Indústrias Criativas Ltda', 'CI111222', '31-91234-5678', 'financeiro@creativeindustries.com.br', 'Alameda dos Inventores, 250, Belo Horizonte, MG', true),
    ('Eco Solutions Brasil', 'Eco Soluções Ambientais Ltda', 'ES999888', '41-98765-1234', 'sustentabilidade@ecosolutions.com.br', 'Rua Verde, 45, Curitiba, PR', false),
    ('HealthMed Solutions', 'HealthMed Soluções em Saúde Ltda', 'HM333444', '51-97654-3210', 'atendimento@healthmed.com.br', 'Av. Saúde, 78, Porto Alegre, RS', true);

INSERT INTO hiring_company_employee (name, email, phone, code, company_id, is_project_manager)
VALUES
    ('Carlos Silva', 'carlos.silva@techsolutions.com.br', '11-98765-1234', '989.329.842-39', 1, true),
    ('Ana Paula Souza', 'ana.souza@globalservices.com.br', '21-91234-5678', '916.020.773-63', 2, false),
    ('Bruno Oliveira', 'bruno.oliveira@techsolutions.com.br', '31-99876-5432', '012.345.678-90', 1, false),
    ('Mariana Costa', 'mariana.costa@globalservices.com.br', '41-98765-4321', '123.456.789-01', 2, true),
    ('Juliana Ferreira', 'juliana.ferreira@techsolutions.com.br', '51-91234-8765', '234.567.890-12', 1, true),
    ('Ricardo Santos', 'ricardo.santos@globalservices.com.br', '61-99876-5432', '345.678.901-23', 2, false);

INSERT INTO hiring_company_employee (name, email, phone, code, company_id, is_project_manager)
VALUES
    ('Roberto Menezes', 'roberto.menezes@creativeindustries.com.br', '31-91234-5670', '112.233.445-56', 3, true),
    ('Fernanda Silva', 'fernanda.silva@ecosolutions.com.br', '41-97654-3211', '223.344.556-67', 4, false),
    ('Luiz Almeida', 'luiz.almeida@healthmed.com.br', '51-96543-2109', '334.455.667-78', 5, true);


INSERT INTO contracted_company (name, corporate_name, code, phone, email, address)
VALUES ('Alpha Tech Partners', 'Alpha Tecnologia e Consultoria Ltda', 'ATC567890', '21-91234-6789',
        'contact@alphatech.com', 'Rua dos Programadores, 15, Rio de Janeiro, RJ'),
       ('Blue Ocean Logistics', 'Blue Ocean Logística SA', 'BOL123789', '11-92345-6789', 'logistics@blueocean.com',
        'Av. das Exportações, 300, Santos, SP'),
       ('DataSafe Storage Solutions', 'DataSafe Armazenamento Ltda', 'DSA444555', '41-98765-4321',
        'support@datasafe.com', 'Rua dos Arquivos, 90, Curitiba, PR'),
       ('Green Earth Consulting', 'Green Earth Consultoria Ambiental Ltda', 'GEC777888', '31-98765-5432',
        'consultoria@greenearth.com.br', 'Rua Sustentável, 100, Belo Horizonte, MG'),
       ('PowerBuild Engenharia', 'PowerBuild Engenharia e Construção SA', 'PB999000', '51-98765-6789',
        'contato@powerbuild.com', 'Av. dos Engenheiros, 50, Porto Alegre, RS');

INSERT INTO contracted_company_employee (name, email, phone, code, company_id, is_legal_representative)
VALUES
    ('Carlos Almeida', 'carlos.almeida@xyztech.com', '21-91234-6789', '123.456.789-00', 1, true),
    ('Fernanda Lima', 'fernanda.lima@techworld.com', '31-98765-4321', '234.567.890-11', 1, false),
    ('Juliano Pereira', 'juliano.pereira@innovate.com', '41-99876-5432', '345.678.901-22', 2, true),
    ('Larissa Souza', 'larissa.souza@creatives.com', '51-91234-8765', '456.789.012-33', 2, false),
    ('Rodrigo Santos', 'rodrigo.santos@techsolutions.com', '61-98765-4321', '567.890.123-44', 1, true),
    ('Patrícia Costa', 'patricia.costa@services.com', '71-99876-5432', '678.901.234-55', 2, false);

INSERT INTO contracted_company_employee (name, email, phone, code, company_id, is_legal_representative)
VALUES
    ('Daniela Carvalho', 'daniela.carvalho@alphatech.com', '21-92345-6788', '445.566.778-99', 3, false),
    ('Carlos Martins', 'carlos.martins@blueocean.com', '11-97654-3212', '556.677.889-00', 4, true),
    ('Marta Ribeiro', 'marta.ribeiro@datasafe.com', '41-96543-2108', '667.788.990-11', 3, false),
    ('João Farias', 'joao.farias@greenearth.com.br', '31-97654-3210', '778.899.001-22', 4, true),
    ('Alberto Souza', 'alberto.souza@powerbuild.com', '51-96543-2107', '889.900.112-33', 5, false);

INSERT INTO payment_method (name, frequency)
VALUES
    ('Mensal', 1),
    ('Bimestral', 2),
    ('Trimestral', 3),
    ('Semestral', 6),
    ('Anual', 12),
    ('Bianual', 24);

INSERT INTO contract_type (name, contract_objective)
VALUES
    ('Desenvolvimento de Software', 'Desenvolvimento de uma plataforma web personalizada'),
    ('Consultoria Logística', 'Consultoria e otimização de processos logísticos');

INSERT INTO contract_item (name, type, contract_type_id)
VALUES
    ('Desenvolvimento Backend', 'SERVICE', 1),
    ('Desenvolvimento Frontend', 'SERVICE', 1),
    ('Consultoria de Processos', 'SERVICE', 2),
    ('Relatório de apontamentos', 'DELIVERY', 2);

INSERT INTO contract (name, contract_type_id, contract_objective, start_date, end_date, contracted_value, payment_method_id, execution_local, latitude, longitude, subsidiary_company_id, contract_manager_id, contracted_company_id, legal_representative_id, status, financial_progress)
VALUES
    ('Plataforma Web Tech Solutions', 1, 'Desenvolvimento de uma plataforma web completa', '2024-01-01', '2024-12-31', 100000, 3, 'São Paulo', -23.5505, -46.6333, 1, 1, 1, 1, 'IN_PROGRESS', 50),
    ('Otimização Logística Blue Ocean', 2, 'Consultoria para otimização de processos logísticos', '2024-03-01', '2024-09-30', 200000, 3, 'Santos', -23.9535, -46.3354, 2, 2, 2, 2, 'IN_PROGRESS', 33);

INSERT INTO contract_item (name, type, scheduled_date, finished_date, contract_id)
VALUES
    ('Desenvolvimento Backend', 'SERVICE', '2024-10-01', '2024-10-01', 1),
    ('Desenvolvimento Frontend', 'SERVICE', '2024-10-01', '2024-10-01', 1),
    ('Treinamento Equipe', 'SERVICE', '2024-11-01', NULL, 1),
    ('Consultoria de Processos', 'SERVICE', '2024-04-01', '2024-04-01', 2),
    ('Relatório de apontamentos', 'DELIVERY', '2024-08-01', '2024-08-01', 2),
    ('Monitoramento Pós-Projeto', 'SERVICE', '2024-09-01', '2024-09-01', 2);

INSERT INTO installment (value, scheduled_payment_date, payment_date, payment_receipturl, contract_id)
VALUES
    (25000, '2024-03-01', '2024-03-15', NULL, 1),
    (25000, '2024-06-01', '2024-06-15', NULL, 1),
    (25000, '2024-09-01', NULL, NULL, 1),
    (25000, '2024-12-01', NULL, NULL, 1);

INSERT INTO installment (value, scheduled_payment_date, payment_date, payment_receipturl, contract_id)
VALUES
    (66000, '2024-03-01', '2024-03-20', NULL, 2),
    (67000, '2024-06-01', '2024-06-20', NULL, 2),
    (67000, '2024-09-01', NULL, NULL, 2);

INSERT INTO contract (name, contract_type_id, contract_objective, start_date, end_date, contracted_value, payment_method_id, execution_local, latitude, longitude, subsidiary_company_id, contract_manager_id, contracted_company_id, legal_representative_id, status, financial_progress)
VALUES
    ('Solução Ambiental Eco Solutions', 1, 'Desenvolvimento de sistema de monitoramento ambiental', '2024-02-01', '2024-10-31', 150000, 6, 'Curitiba', -25.4372, -49.2691, 4, 4, 4, 4, 'CANCELED', 0),
    ('Sistema de Armazenamento DataSafe', 2, 'Consultoria para otimização de armazenamento', '2024-01-15', '2024-06-15', 120000, 2, 'Curitiba', -25.4372, -49.2691, 3, 5, 3, 3, 'PARALYZED', 25),
    ('Consultoria em Processos PowerBuild', 2, 'Consultoria em processos para construção', '2024-04-01', '2025-03-31', 180000, 1, 'Porto Alegre', -30.0346, -51.2177, 5, 6, 5, 5, 'IN_PROGRESS', 10);

-- Para o contrato "Consultoria Ambiental Green Earth"
INSERT INTO contract_item (name, type, scheduled_date, finished_date, contract_id)
VALUES
    ('Análise de Impacto Ambiental', 'SERVICE', '2024-02-01', NULL, 3),
    ('Relatório Final', 'DELIVERY', '2024-06-01', NULL, 3),
    ('Treinamento de Equipe', 'SERVICE', '2024-03-01', NULL, 3);

INSERT INTO installment (value, scheduled_payment_date, payment_date, payment_receipturl, contract_id)
VALUES
    (20000, '2024-03-01', NULL, NULL, 3),
    (20000, '2024-06-01', NULL, NULL, 3),
    (20000, '2024-09-01', NULL, NULL, 3),
    (20000, '2024-12-01', NULL, NULL, 3),
    (20000, '2025-03-01', NULL, NULL, 3);

-- Para o contrato "Construção de Subestação PowerBuild"
INSERT INTO contract_item (name, type, scheduled_date, finished_date, contract_id)
VALUES
    ('Projeto de Engenharia', 'SERVICE', '2024-07-01', NULL, 4),
    ('Montagem de Estrutura', 'SERVICE', '2024-10-01', NULL, 4),
    ('Instalação de Equipamentos', 'SERVICE', '2024-12-01', NULL, 4);

INSERT INTO installment (value, scheduled_payment_date, payment_date, payment_receipturl, contract_id)
VALUES
    (25000, '2024-07-01', NULL, NULL, 4),
    (25000, '2024-10-01', NULL, NULL, 4),
    (25000, '2025-01-01', NULL, NULL, 4),
    (25000, '2025-04-01', NULL, NULL, 4);

-- Para o contrato "Atualização de Data Centers DataSafe"
INSERT INTO contract_item (name, type, scheduled_date, finished_date, contract_id)
VALUES
    ('Análise de Requisitos', 'SERVICE', '2024-01-15', NULL, 5),
    ('Implementação de Infraestrutura', 'SERVICE', '2024-04-01', NULL, 5),
    ('Teste e Validação', 'SERVICE', '2024-06-15', NULL, 5),
    ('Treinamento de Equipe Técnica', 'SERVICE', '2024-08-01', NULL, 5);

INSERT INTO installment (value, scheduled_payment_date, payment_date, payment_receipturl, contract_id)
VALUES
    (33000, '2024-02-01', NULL, NULL, 5),
    (33000, '2024-05-01', NULL, NULL, 5),
    (34000, '2024-08-01', NULL, NULL, 5);
