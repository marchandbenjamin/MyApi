# My API

Demo project using Spring Boot 3.4.4 with Java 21.

## 🚀 Prérequis

Avant de pouvoir lancer le projet, assure-toi d’avoir installé :

- **Java 21** : [OpenJDK 21 (Adoptium)](https://adoptium.net/en-GB/temurin/releases/?version=21)
- **Maven 3.9+** : [https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi)
- **Git** : [https://git-scm.com/downloads](https://git-scm.com/downloads)
- (Optionnel mais recommandé) **IDE** : [IntelliJ IDEA](https://www.jetbrains.com/idea/) ou [VSCode](https://code.visualstudio.com/)

> 💡 Vérifie les versions avec :  
> `java -version`, `mvn -v`, `git --version`

---

## 📦 Installation

1. **Clone le projet**

```bash
git clone git@github.com:marchandbenjamin/MyApi.git
cd MyApi
```

2. **Compile et télécharge les dépendances**

```bash
mvn clean install
```

3. **Lance l’application**

```bash
mvn spring-boot:run
```

> Par défaut, l’API tourne sur [http://localhost:8080](http://localhost:8080)

---

## 🧪 Lancer les tests

```bash
mvn test
```

---

## 🛠 Structure du projet

```
src/
 └── main/
     └── java/com/example/
         └── myapi/         # Ton code source ici
 └── test/                  # Les tests unitaires
```

---

## 🧰 Technologies

- Java 21
- Spring Boot 3.4.4
- Maven
- Lombok

---

## 📄 Licence

Projet de démonstration — libre de réutilisation 🚀
```