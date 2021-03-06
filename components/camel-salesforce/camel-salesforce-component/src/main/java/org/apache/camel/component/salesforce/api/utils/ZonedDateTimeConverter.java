/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.salesforce.api.utils;

import java.time.ZonedDateTime;

import com.thoughtworks.xstream.converters.SingleValueConverter;

import static org.apache.camel.component.salesforce.api.utils.DateTimeHandling.ISO_OFFSET_DATE_TIME;

final class ZonedDateTimeConverter implements SingleValueConverter {

    static final SingleValueConverter INSTANCE = new ZonedDateTimeConverter();

    private ZonedDateTimeConverter() {
    }

    @Override
    public boolean canConvert(@SuppressWarnings("rawtypes") final Class type) {
        return ZonedDateTime.class.equals(type);
    }

    @Override
    public Object fromString(final String value) {
        return ZonedDateTime.parse(value, ISO_OFFSET_DATE_TIME);
    }

    @Override
    public String toString(final Object value) {
        if (value == null) {
            return null;
        }

        final ZonedDateTime zonedDateTime = (ZonedDateTime) value;

        return ISO_OFFSET_DATE_TIME.format(zonedDateTime);
    }

}
