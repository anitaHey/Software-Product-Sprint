// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.data;

/** An item on a message list. */
public final class Message {

  private final long id;
  private final String username;
  private final String content;
  private final String date;
  private final String image_url;
  private final long timestamp;

  public Message(long id, String username, String content, String image_url, String date, long timestamp) {
    this.id = id;
    this.username = username;
    this.content = content;
    this.image_url = image_url;
    this.date = date;
    this.timestamp = timestamp;
  }
}