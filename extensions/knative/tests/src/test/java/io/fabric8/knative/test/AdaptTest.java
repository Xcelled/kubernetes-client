/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.knative.test;

import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.knative.client.KnativeClient;
import io.fabric8.knative.mock.KnativeMockServer;
import io.fabric8.kubernetes.client.KubernetesClient;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AdaptTest {

  private KnativeMockServer mock = new KnativeMockServer();

  @BeforeEach
  public void setUp() {
    mock.init();
  }

  @AfterEach
  public void tearDown() throws IOException {
    mock.destroy();
  }

  @Test
  public void testAdapt() {
    KnativeClient sc = mock.createKnative();
    KubernetesClient kc = new DefaultKubernetesClient(sc.getConfiguration());
    assertNotNull(kc.adapt(KnativeClient.class));
  }
}
