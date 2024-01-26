/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.mail.jmh;

import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class MimeMultipartBenchmarkTest {

    private MimeMultipart mimeMultipart;
    private BodyPart bodyPart;

    @Setup(org.openjdk.jmh.annotations.Level.Iteration)
    public void setup() {
        mimeMultipart = new MimeMultipart();
        bodyPart = new MimeBodyPart();
    }

    @Benchmark
    public void addBodyPartBenchmark() throws MessagingException {
        mimeMultipart.addBodyPart(bodyPart);
    }

    @Benchmark
    public void setTextBenchmark() throws MessagingException {
        bodyPart.setText("Example Text");
    }

    public static void main(String[] args) throws Exception {
        // Run the benchmark methods
        org.openjdk.jmh.Main.main(args);
    }
}
