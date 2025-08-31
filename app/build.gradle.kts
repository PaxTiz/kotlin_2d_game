import org.gradle.nativeplatform.platform.internal.DefaultNativePlatform

plugins {
	// Apply the shared build logic from a convention plugin.
	// The shared code is located in `buildSrc/src/main/kotlin/kotlin-jvm.gradle.kts`.
	id("buildsrc.convention.kotlin-jvm")
	
	// Apply the Application plugin to add support for building an executable JVM application.
	application
}

dependencies {
	// implementation(project(":level_editor"))
}

application {
	if (DefaultNativePlatform.getCurrentOperatingSystem().isMacOsX) {
		applicationDefaultJvmArgs = listOf("-XstartOnFirstThread")
	}
	
	mainClass = "fr.vcernuta.app.AppKt"
}

distributions {
	main {
		contents {
			from("$rootDir/resources") {
				into("resources")
			}
		}
	}
}
