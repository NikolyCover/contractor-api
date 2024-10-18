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
