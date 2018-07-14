# EasyLend
Projeto disciplina IP2 UFRPE

## O que ele faz?
<p>O aplicativo tem como objetivo propociona ao usuário a conteudo de busca de filmes e </p>
<p>direcionamente para plataforma online</p>
<p>com a criação de login e senha para cada usuário.</p>

## Versão e dependencias
Versão jdk1.8.0_152 ou superior
  
## Funcionalidades
<p>1. Cadastro e Login</p>
<p>2. Visualização de conteudo web</p>
<p>3. Seleção de conteudo para lista de "favoritos"</p>
<p>4. Compartilhamento de conteudo entre usuários</p>

### Dependecias maven

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>br.ip2.project</groupId>
    <artifactId>easylend</artifactId>
    <version>1.0-SNAPSHOT</version>
    <properties>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
    </properties>

    <dependencies>
        <!-- https://mvnrepository.com/artifact/nz.ac.waikato.cms.weka/weka-stable -->
        <dependency>
            <groupId>nz.ac.waikato.cms.weka</groupId>
            <artifactId>weka-stable</artifactId>
            <version>3.8.0</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/com.google.code.gson/gson -->
        <dependency>
            <groupId>com.google.code.gson</groupId>
            <artifactId>gson</artifactId>
            <version>2.8.5</version>
        </dependency>

    </dependencies>
    
</project>
