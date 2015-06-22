/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */

package org.apache.qpid.jms.test.testpeer.matchers;

import org.apache.qpid.proton.amqp.Symbol;
import org.apache.qpid.proton.amqp.UnsignedLong;
import org.apache.qpid.jms.test.testpeer.AmqpPeerRunnable;
import org.apache.qpid.jms.test.testpeer.FrameType;
import org.apache.qpid.jms.test.testpeer.FrameWithNoPayloadMatchingHandler;
import org.hamcrest.Matcher;

/**
 * Generated by generate-matchers.xsl, which resides in this package.
 */
public class SaslOutcomeMatcher extends FrameWithNoPayloadMatchingHandler
{
    /** Note that the ordinals of the Field enums match the order specified in the AMQP spec */
    public enum Field
    {
        CODE,
        ADDITIONAL_DATA,
    }

    public SaslOutcomeMatcher()
    {
        super(FrameType.SASL,
              ANY_CHANNEL,
              UnsignedLong.valueOf(0x0000000000000044L),
              Symbol.valueOf("amqp:sasl-outcome:list"));
    }

    @Override
    public SaslOutcomeMatcher onCompletion(AmqpPeerRunnable onCompletion)
    {
        super.onCompletion(onCompletion);
        return this;
    }

    public SaslOutcomeMatcher withCode(Matcher<?> m)
    {
        getMatchers().put(Field.CODE, m);
        return this;
    }

    public SaslOutcomeMatcher withAdditionalData(Matcher<?> m)
    {
        getMatchers().put(Field.ADDITIONAL_DATA, m);
        return this;
    }

    public Object getReceivedCode()
    {
        return getReceivedFields().get(Field.CODE);
    }

    public Object getReceivedAdditionalData()
    {
        return getReceivedFields().get(Field.ADDITIONAL_DATA);
    }

    @Override
    protected Enum<?> getField(int fieldIndex)
    {
        return Field.values()[fieldIndex];
    }
}

