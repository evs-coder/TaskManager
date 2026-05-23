# 📝 Gerenciador de Tarefas (To-Do List) com Persistência em CSV

Este é um sistema de gerenciamento de tarefas em console desenvolvido em Java. O projeto foi criado com o objetivo de praticar conceitos de Orientação a Objetos, manipulação de arquivos (I/O) e o uso de Streams do Java 8+.

O grande diferencial deste projeto é que os dados não somem quando o programa é fechado: todas as tarefas são salvas e lidas diretamente de um arquivo no formato CSV.

---

## 🚀 Funcionalidades

- **Criar Tarefas:** Adiciona novas tarefas à lista.
- **Listar Tarefas:** Exibe todas as tarefas cadastradas no sistema.
- **Concluir Tarefa:** Altera o status de uma tarefa específica para "Concluída".
- **Excluir Tarefa:** Remove permanentemente uma tarefa do sistema.
- **Persistência em CSV:** Salva o estado atual das tarefas automaticamente e recarrega os dados ao iniciar o programa, sem duplicar registros.

---

## 🛠️ Tecnologias Utilizadas

- **Java 25.0.3**
- **Java Streams API** (para filtragem e busca de dados)
- **BufferedWriter / BufferedReader** (para leitura e escrita eficiente em disco)

---

## 📋 Como Executar o Projeto

### Pré-requisitos
Você vai precisar apenas do **Java JDK** instalado na sua máquina.

### Passo a passo
1. Clone este repositório no seu computador:
```bash
   git clone https://github.com/evs-coder/TaskManager.git
   ```

2. Navega até a pasta do projeto:

```Bash
   cd TaskManager
```
3. Compile e rode o arquivo principal:

```Bash
   javac Main.java
   java Main
``` 

## 🧠 Aprendizados neste projeto
Este projeto marcou a minha evolução em:

- Entendimento do bloco try-with-resources para fechamento automático de arquivos.
- Uso correto de buffers (BufferedReader/BufferedWriter) para otimizar operações de leitura e escrita.
- Manipulação de Strings com os métodos .split() e .trim() para tratamento de dados puros.
- Aplicação prática da estratégia de "Lê, Filtra e Reescreve" para remoção e atualização de dados em arquivos sequenciais.


Desenvolvido com 💻 por Elvis Lima.