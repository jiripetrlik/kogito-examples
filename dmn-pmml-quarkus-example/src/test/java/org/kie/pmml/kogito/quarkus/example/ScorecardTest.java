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

import java.util.Collections;
import java.util.Map;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;

import static org.kie.pmml.kogito.quarkus.example.CommonTestUtils.testDescriptive;
import static org.kie.pmml.kogito.quarkus.example.CommonTestUtils.testResult;

@QuarkusTest
public class ScorecardTest {

    private static final String BASE_PATH = "/SimpleScorecard";
    private static final String TARGET = "score";

    static {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    void testEvaluateScorecardResult() {
        String inputData = "{ \"input1\":5.0, \"input2\":-10.0 }";
        testResult(inputData, BASE_PATH, TARGET, -15f);
    }

    @Test
    void testEvaluateScorecardResultDescriptive() {
        String inputData = "{ \"input1\":5.0, \"input2\":-10.0 }";
        final Map<String, Object> expectedResultMap = Collections.singletonMap(TARGET, -15f);
        testDescriptive(inputData, BASE_PATH, TARGET, expectedResultMap);
    }
}
