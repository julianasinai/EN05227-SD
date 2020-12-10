# EN05227-SD #

Usando Java RMI, Pyro ou outra linguagem, estabeleça a comunicação do cliente com o servidor
RMI concorrente por threads.
Comente o tempo de comunicação, tempo total de consulta/atualização, tamanho de código,
confiabilidade, nível de abstração, usando um objeto servidor de perfis (pessoas) que suporta
múltiplos usuários. O servidor armazena as seguintes informações sobre os perfis: email (chave),
nome, sobrenome, residência, formação acadêmica, habilidades e experiência profissional. Um
exemplo de perfil é mostrado na última página deste documento.
Pelo menos as seguintes operações devem ser realizadas por um usuário no servidor:

1. listar todas as pessoas formadas em um determinado curso;
2. listar as habilidades dos perfis que moram em uma determinada cidade;
3. acrescentar uma nova experiência em um perfil;
4. dado o email do perfil, retornar sua experiência;
5. listar todas as informações de todos os perfis;
6. dado o email de um perfil, retornar suas informações.

Para cada tipo de operação, os tempos apresentados devem ser a média de pelo menos 20 execuções.
Mostrar também o intervalo de confiança com nível de confiança de 95%. Cliente e Servidor
devem estar executando em máquinas diferentes (opcional: em máquinas de redes diferentes).
Entregar: os programas desenvolvidos e um texto em .pdf descrevendo os experimentos. Se
possível comparar o uso do RMI com o socket TCP.

- Implementação (60% da nota)
1. Tempo de comunicação não foi calculado (-2.0)
2. Não implementa uma operação (-2.0)

- Relatório (40% da nota)
1. Não explicou os campos das mensagens (-2.0)
2. Não explicou os dados/resultados (-2.0)
3. Não apresentou gráficos/tabelas (-2.0)
4. Não mostra intervalo de confiança (-1.0)
5. Não tem conclusão (-1.0)
6. Não mencionar nível de confiança (-0.5)
7. Não mencionou que no RMI o paralelismo por Thread é automático (-1.5)

**Exemplo de perfil:** 
**Email:** maria_silva@gmail.com
**Nome:** Maria Sobrenome: Silva
**Foto:** Imagem em JPEG, PNG, etc
**Residência:** Belém
**Formação Acadêmica:** Ciência da Computação
**Habilidades:** Análise de Dados, Internet das Coisas, Computação em Nuvem
Experiência: (1) Estágio de 1 ano na Empresa X, onde trabalhei como analista de dados
(2) Trabalhei com IoT e Computação em Nuvem por 5 anos na Empresa Y
