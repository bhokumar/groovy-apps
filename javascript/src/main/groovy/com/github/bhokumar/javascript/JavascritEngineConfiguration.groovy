package com.github.bhokumar.javascript

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import javax.script.ScriptEngine
import javax.script.ScriptEngineManager

@Configuration
class JavascritEngineConfiguration {

    @Bean
    ScriptEngine getJavascriptEngine() {
        ScriptEngineManager manager = new ScriptEngineManager()
        manager.getEngineByName('javascript')
    }
}
