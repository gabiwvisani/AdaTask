# AdaTask - Gerenciador de Tarefas
Descrição
Este projeto é um gerenciador de tarefas simples desenvolvido em Java. Ele permite que você crie, visualize, edite e exclua tarefas de diferentes tipos, como pessoais, de estudo e de trabalho.

Estrutura do Projeto
O projeto está dividido em três principais pacotes:

Domain: Contém as classes que representam as tarefas (BaseTask, PersonalTask, StudyTask, WorkTask).
Repository: Contém classes de repositório (TaskRepository, PersonalRepository, StudyRepository, WorkRepository) responsáveis por armazenar, adicionar, excluir e recuperar tarefas.
Service: Contém as classes de serviço (Service, PersonalService, StudyService, WorkService) que fornecem funcionalidades para manipular as tarefas.

Funcionalidades
Tarefas Pessoais
Adicione tarefas pessoais, indicando se envolvem outras pessoas.
Exclua tarefas pessoais, com validação de existência.
Caso seja uma tarefa com mais pessoas o programa alerta o usuário ao criar a tarefa e ao tentar modificar a mesma que ele deve comunicar da tarefa com as outras pessoas.
Tarefas de Estudo
Adicione tarefas de estudo, especificando a matéria.
Exclua tarefas de estudo, com validação de existência.
Tarefas de Trabalho
Adicione tarefas de trabalho, informando se envolvem outros colegas.
Caso seja uma tarefa com mais colegas de trabalho o programa alerta o usuário ao criar a tarefa e ao tentar modificar a mesma que ele deve comunicar da tarefa com os outros colegas.
Exclua tarefas de trabalho, com validação de existência. 
Além disso, verifica se a data da tarefa é dia útil antes de adicionar ou editar a data. Não permitindo assim cadastro de tarefas de trabalho nos finais de semana.

Como Executar
Clone o repositório para a sua máquina local.
Abra o projeto em sua IDE Java favorita.
Execute a classe Main para iniciar o programa.
