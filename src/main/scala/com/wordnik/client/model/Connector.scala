package com.wordnik.client.model



case class Connector (
  id: Int,
  name: String,
  display_name: String,
  image: String,
  get_it_url: String,
  short_description: String,
  long_description: String,
  enabled: Boolean,
  oauth: Boolean
)
