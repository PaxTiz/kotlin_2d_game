plugins {
	`kotlin-dsl`
}

kotlin {
	jvmToolchain(20)
}

dependencies {
	implementation(libs.kotlinGradlePlugin)
}
