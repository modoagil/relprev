/*
 *     Copyright 2014 Modo Ágil
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package br.com.modoagil.util;

import java.lang.reflect.Field;

import org.springframework.util.ReflectionUtils;

/**
 * Métodos utilitários para reflection
 *
 * @since 07/12/2014
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
public final class ReflectionUtil {

    private ReflectionUtil() { }

    /**
     * Seta em um atributo de uma classe o atributo com nome '{@code name}' o valor '{@code value}' no objeto desta instância
     *
     * @param target
     *            objeto a ter o campo e valores setados
     * @param name
     *            nome do atributo a ser setado o conteúdo
     * @param value
     *            conteúdo a ser setado
     * @see ReflectionUtils#findField(Class, String)
     * @see ReflectionUtils#makeAccessible(Field)
     * @see ReflectionUtils#setField(Field, Object, Object)
     */
    public static void setField(final Object target, final String name, final Object value) {
        final Field field = ReflectionUtils.findField(target.getClass(), name);
        ReflectionUtils.makeAccessible(field);
        ReflectionUtils.setField(field, target, value);
    }

}
