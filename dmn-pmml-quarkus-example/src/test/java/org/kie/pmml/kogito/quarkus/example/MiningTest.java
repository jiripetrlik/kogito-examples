/*
 * Copyright 2021 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kie.pmml.kogito.quarkus.example;

import org.junit.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;

import static org.kie.pmml.kogito.quarkus.example.CommonTestUtils.testResult;

@QuarkusTest
public class MiningTest {

    private static final String BASE_PATH = "/SegmentationMeanMining";
    private static final String TARGET = "result";

    static {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    public void testEvaluateMiningModel() {
        String inputData = "{ \"x\":2.0, \"y\":5.0 }";
        testResult(inputData, BASE_PATH, TARGET, 15.5f);
    }

}
