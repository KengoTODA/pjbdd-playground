plugins {
    kotlin("jvm") version "1.9.20"
    id("org.jetbrains.dokka") version "1.8.20"
    id("io.gitlab.arturbosch.detekt") version "1.23.1"
}

repositories {
    mavenCentral()
    ivy {
        url = uri("https://www.sosy-lab.org/ivy")
        patternLayout {
            artifact("[organisation]/[module]/[artifact]-v1.0.10-10(-[classifier]).[ext]")
            // the version part contains an unexpected period
            ivy("[organisation]/[module]/ivy-v.1.0.10-10.xml")
        }
    }
}
dependencies {
    implementation("org.sosy_lab:pjbdd:v.1.0.10-10") {
        targetConfiguration = "runtime"
    }
}

tasks {
    named<io.gitlab.arturbosch.detekt.Detekt>("detekt") {
        reports {
            sarif.required = true
        }
    }
}
