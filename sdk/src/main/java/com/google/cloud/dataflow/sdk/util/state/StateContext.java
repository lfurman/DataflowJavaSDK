/*
 * Copyright (C) 2015 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.cloud.dataflow.sdk.util.state;

import com.google.cloud.dataflow.sdk.annotations.Experimental;
import com.google.cloud.dataflow.sdk.annotations.Experimental.Kind;

/**
 * Interface for interacting with per-key persistent state identified via a
 * {@link StateTag}.
 *
 * <p>For internal use only.
 */
@Experimental(Kind.STATE)
public interface StateContext<K> {
  /**
   * Access the storage for the given {@code address} in the current window.
   *
   * <p>Never accounts for merged windows. When windows are merged, any state accessed via
   * this method must be eagerly combined and written into the result window.
   */
  <StateT extends State> StateT access(StateTag<? super K, StateT> address);
}