Projeto FIAP ADS RM: 88572 - 2023

*****
Inicialmente, minha ideia era criar uma FinTech para facilitar e desburocratizar aos pequenos empreendedores a criação de seu negócio online para vender na internet. Mas, eu entendi que há mais demanda para educação financeira, tendo em vista que, no Brasil, não temos essa disciplina em nenhum momento da vida e somos obrigados a aprender à força na vida adulta.

Portanto, a ideia é uma plataforma de cursos voltados para educação financeira com várias categorias e níveis diferentes de cursos, onde os cursos mais básicos que vão orientar sobre os conceitos mais básicos de economia e finanças e ajudar o investidor a criar sua primeira carteira de investimentos, serão gratuitos. Cursos mais refinados e avançados sobre tópicos mais específicos, serão pagos.
****

--------------- ADENDOS ---------------
Eu incluí no projeto 2 camadas a mais que entendi necessárias:

Services:
Camada 'Services' para que fosse abstraído toda e qualquer regra de negócios dentro dela, desta forma garantindo que a camada de Controller irá apenas fazer o que ela, de fato, precisa fazer. Pode ser redundante para algumas situações, como criação de métodos de CRUD básicos, mas entendo que é uma boa prática.

Config:
Camada criada com uma classe que instancia objetos ao iniciar a aplicação fazendo uso do "CommandLineRunner" apenas para facilitar a execução de testes. Não vou manter esta camada na versão final do projeto (ou pelo menos acredito que não seja necessário).

Implementei requisições de PUT, POST e DELETE apenas para a rota /users porque, seguindo a regra de negócios de uma plataforma de cursos, acredito que não deve permitir cadastrar, atualizar e nem deletar um curso ou uma categoria de curso via Webservices.

Implementei Exceptions personalizadas.

Incluí no projeto a Collections que criei do POSTMAN para facilitar o teste por parte do professor que irá avaliar a atividade.