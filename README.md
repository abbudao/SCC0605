# ARQUIVOS

**jason.jj**: Arquivo de definição dos tokens e das produções

**test.txt**: Arquivo que contém um programa para teste

# COMPILAÇÃO:

javacc jason.jj

javac {Aqui vão todos os arquivos .java}

# TESTE:

cat test.txt | java Jason
