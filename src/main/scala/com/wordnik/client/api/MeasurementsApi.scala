/**
 * QuantiModo
 * Welcome to QuantiModo API! QuantiModo makes it easy to retrieve normalized user data from a wide array of devices and applications. [Learn about QuantiModo](https://quantimo.do) or contact us at <api@quantimo.do>.         Before you get started, you will need to: * Sign in/Sign up, and add some data at [https://app.quantimo.do/api/v2/account/connectors](https://app.quantimo.do/api/v2/account/connectors) to try out the API for yourself * Create an app to get your client id and secret at [https://app.quantimo.do/api/v2/apps](https://app.quantimo.do/api/v2/apps) * As long as you're signed in, it will use your browser's cookie for authentication.  However, client applications must use OAuth2 tokens to access the API.     ## Application Endpoints These endpoints give you access to all authorized users' data for that application. ### Getting Application Token Make a `POST` request to `/api/v2/oauth/access_token`         * `grant_type` Must be `client_credentials`.         * `clientId` Your application's clientId.         * `client_secret` Your application's client_secret.         * `redirect_uri` Your application's redirect url.                ## Example Queries ### Query Options The standard query options for QuantiModo API are as described in the table below. These are the available query options in QuantiModo API: <table>            <thead>                <tr>                    <th>Parameter</th>                    <th>Description</th>                </tr>            </thead>            <tbody>                <tr>                    <td>limit</td>                    <td>The LIMIT is used to limit the number of results returned.  So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records.</td>                </tr>                <tr>                    <td>offset</td>                    <td>Suppose you wanted to show results 11-20. You'd set the    offset to 10 and the limit to 10.</td>                </tr>                <tr>                    <td>sort</td>                    <td>Sort by given field. If the field is prefixed with '-', it    will sort in descending order.</td>                </tr>            </tbody>        </table>         ### Pagination Conventions Since the maximum limit is 200 records, to get more than that you'll have to make multiple API calls and page through the results. To retrieve all the data, you can iterate through data by using the `limit` and `offset` query parameters.For example, if you want to retrieve data from 61-80 then you can use a query with the following parameters,         `/v2/variables?limit=20&offset=60`         Generally, you'll be retrieving new or updated user data. To avoid unnecessary API calls, you'll want to store your last refresh time locally.  Initially, it should be set to 0. Then whenever you make a request to get new data, you should limit the returned results to those updated since your last refresh by appending append         `?lastUpdated=(ge)&quot2013-01-D01T01:01:01&quot`         to your request.         Also for better pagination, you can get link to the records of first, last, next and previous page from response headers: * `Total-Count` - Total number of results for given query * `Link-First` - Link to get first page records * `Link-Last` - Link to get last page records * `Link-Prev` - Link to get previous records set * `Link-Next` - Link to get next records set         Remember, response header will be only sent when the record set is available. e.g. You will not get a ```Link-Last``` & ```Link-Next``` when you query for the last page.         ### Filter operators support API supports the following operators with filter parameters: <br> **Comparison operators**         Comparison operators allow you to limit results to those greater than, less than, or equal to a specified value for a specified attribute. These operators can be used with strings, numbers, and dates. The following comparison operators are available: * `gt` for `greater than` comparison * `ge` for `greater than or equal` comparison * `lt` for `less than` comparison * `le` for `less than or equal` comparison         They are included in queries using the following format:         `(<operator>)<value>`         For example, in order to filter value which is greater than 21, the following query parameter should be used:         `?value=(gt)21` <br><br> **Equals/In Operators**         It also allows filtering by the exact value of an attribute or by a set of values, depending on the type of value passed as a query parameter. If the value contains commas, the parameter is split on commas and used as array input for `IN` filtering, otherwise the exact match is applied. In order to only show records which have the value 42, the following query should be used:         `?value=42`         In order to filter records which have value 42 or 43, the following query should be used:         `?value=42,43` <br><br> **Like operators**         Like operators allow filtering using `LIKE` query. This operator is triggered if exact match operator is used, but value contains `%` sign as the first or last character. In order to filter records which category that start with `Food`, the following query should be used:         `?category=Food%` <br><br> **Negation operator**         It is possible to get negated results of a query by prefixed the operator with `!`. Some examples:         `//filter records except those with value are not 42 or 43`<br> `?value=!42,43`         `//filter records with value not greater than 21`<br> `?value=!(ge)21` <br><br> **Multiple constraints for single attribute**         It is possible to apply multiple constraints by providing an array of query filters:         Filter all records which value is greater than 20.2 and less than 20.3<br> `?value[]=(gt)20.2&value[]=(lt)20.3`         Filter all records which value is greater than 20.2 and less than 20.3 but not 20.2778<br> `?value[]=(gt)20.2&value[]=(lt)20.3&value[]=!20.2778`<br><br> 
 *
 * OpenAPI spec version: 2.0.6
 * Contact: apiteam@swagger.io
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wordnik.client.api

import com.wordnik.client.model.MeasurementSource
import com.wordnik.client.model.Measurement
import com.wordnik.client.model.MeasurementDelete
import com.wordnik.client.model.CommonResponse
import com.wordnik.client.model.MeasurementSet
import com.wordnik.client.model.MeasurementRange
import java.io.File
import com.wordnik.client.model.Inline_response_200_12
import com.wordnik.client.model.Inline_response_200_11

import java.io.File

import org.scalatra.{ TypedParamSupport, ScalatraServlet }
import org.scalatra.swagger._
import org.json4s._
import org.json4s.JsonDSL._
import org.scalatra.json.{ JValueResult, JacksonJsonSupport }
import org.scalatra.servlet.{FileUploadSupport, MultipartConfig, SizeConstraintExceededException}

import scala.collection.JavaConverters._

class MeasurementsApi (implicit val swagger: Swagger) extends ScalatraServlet 
    with FileUploadSupport
    with JacksonJsonSupport
    with SwaggerSupport {
  protected implicit val jsonFormats: Formats = DefaultFormats

  protected val applicationDescription: String = "MeasurementsApi"
  override protected val applicationName: Option[String] = Some("Measurements")

  before() {
    contentType = formats("json")
    response.headers += ("Access-Control-Allow-Origin" -> "*")
  }
  

  val v1MeasurementSourcesGetOperation = (apiOperation[MeasurementSource]("v1MeasurementSourcesGet")
      summary "Get measurement sources"
      parameters()
  )

  get("/v1/measurementSources",operation(v1MeasurementSourcesGetOperation)) {
  }

  

  val v1MeasurementSourcesPostOperation = (apiOperation[Unit]("v1MeasurementSourcesPost")
      summary "Add a data source"
      parameters(bodyParam[MeasurementSource]("body").description(""),
        queryParam[String]("accessToken").description("").optional)
  )

  post("/v1/measurementSources",operation(v1MeasurementSourcesPostOperation)) {
    
    
    bodyParam[MeasurementSource]("body").description("")
    println("body: " + body)
    
    
                val accessToken = params.getAs[String]("accessToken")

    println("accessToken: " + accessToken)
  }

  

  val v1MeasurementsDailyGetOperation = (apiOperation[Measurement]("v1MeasurementsDailyGet")
      summary "Get daily measurements for this user"
      parameters(queryParam[String]("variableName").description(""),
        queryParam[String]("accessToken").description("").optional,
        queryParam[String]("abbreviatedUnitName").description("").optional,
        queryParam[String]("startTime").description("").optional,
        queryParam[String]("endTime").description("").optional,
        queryParam[Int]("groupingWidth").description("").optional,
        queryParam[String]("groupingTimezone").description("").optional,
        queryParam[Int]("limit").description("").optional,
        queryParam[Int]("offset").description("").optional,
        queryParam[Int]("sort").description("").optional)
  )

  get("/v1/measurements/daily",operation(v1MeasurementsDailyGetOperation)) {
    
    
                val variableName = params.getAs[String]("variableName")

    println("variableName: " + variableName)
    
    
                val accessToken = params.getAs[String]("accessToken")

    println("accessToken: " + accessToken)
    
    
                val abbreviatedUnitName = params.getAs[String]("abbreviatedUnitName")

    println("abbreviatedUnitName: " + abbreviatedUnitName)
    
    
                val startTime = params.getAs[String]("startTime")

    println("startTime: " + startTime)
    
    
                val endTime = params.getAs[String]("endTime")

    println("endTime: " + endTime)
    
    
                val groupingWidth = params.getAs[Int]("groupingWidth")

    println("groupingWidth: " + groupingWidth)
    
    
                val groupingTimezone = params.getAs[String]("groupingTimezone")

    println("groupingTimezone: " + groupingTimezone)
    
    
                val limit = params.getAs[Int]("limit")

    println("limit: " + limit)
    
    
                val offset = params.getAs[Int]("offset")

    println("offset: " + offset)
    
    
                val sort = params.getAs[Int]("sort")

    println("sort: " + sort)
  }

  

  val v1MeasurementsDeletePostOperation = (apiOperation[CommonResponse]("v1MeasurementsDeletePost")
      summary "Delete a measurement"
      parameters(bodyParam[MeasurementDelete]("body").description(""))
  )

  post("/v1/measurements/delete",operation(v1MeasurementsDeletePostOperation)) {
    
    
    bodyParam[MeasurementDelete]("body").description("")
    println("body: " + body)
  }

  

  val v1MeasurementsGetOperation = (apiOperation[Measurement]("v1MeasurementsGet")
      summary "Get measurements for this user"
      parameters(queryParam[String]("accessToken").description("").optional,
        queryParam[String]("variableName").description("").optional,
        queryParam[String]("variableCategoryName").description("").optional,
        queryParam[String]("source").description("").optional,
        queryParam[String]("value").description("").optional,
        queryParam[String]("lastUpdated").description("").optional,
        queryParam[String]("unit").description("").optional,
        queryParam[String]("startTime").description("").optional,
        queryParam[String]("createdAt").description("").optional,
        queryParam[String]("updatedAt").description("").optional,
        queryParam[String]("endTime").description("").optional,
        queryParam[Int]("groupingWidth").description("").optional,
        queryParam[String]("groupingTimezone").description("").optional,
        queryParam[Int]("limit").description("").optional,
        queryParam[Int]("offset").description("").optional,
        queryParam[Int]("sort").description("").optional)
  )

  get("/v1/measurements",operation(v1MeasurementsGetOperation)) {
    
    
                val accessToken = params.getAs[String]("accessToken")

    println("accessToken: " + accessToken)
    
    
                val variableName = params.getAs[String]("variableName")

    println("variableName: " + variableName)
    
    
                val variableCategoryName = params.getAs[String]("variableCategoryName")

    println("variableCategoryName: " + variableCategoryName)
    
    
                val source = params.getAs[String]("source")

    println("source: " + source)
    
    
                val value = params.getAs[String]("value")

    println("value: " + value)
    
    
                val lastUpdated = params.getAs[String]("lastUpdated")

    println("lastUpdated: " + lastUpdated)
    
    
                val unit = params.getAs[String]("unit")

    println("unit: " + unit)
    
    
                val startTime = params.getAs[String]("startTime")

    println("startTime: " + startTime)
    
    
                val createdAt = params.getAs[String]("createdAt")

    println("createdAt: " + createdAt)
    
    
                val updatedAt = params.getAs[String]("updatedAt")

    println("updatedAt: " + updatedAt)
    
    
                val endTime = params.getAs[String]("endTime")

    println("endTime: " + endTime)
    
    
                val groupingWidth = params.getAs[Int]("groupingWidth")

    println("groupingWidth: " + groupingWidth)
    
    
                val groupingTimezone = params.getAs[String]("groupingTimezone")

    println("groupingTimezone: " + groupingTimezone)
    
    
                val limit = params.getAs[Int]("limit")

    println("limit: " + limit)
    
    
                val offset = params.getAs[Int]("offset")

    println("offset: " + offset)
    
    
                val sort = params.getAs[Int]("sort")

    println("sort: " + sort)
  }

  

  val v1MeasurementsPostOperation = (apiOperation[Unit]("v1MeasurementsPost")
      summary "Post a new set or update existing measurements to the database"
      parameters(bodyParam[MeasurementSet]("body").description(""),
        queryParam[String]("accessToken").description("").optional)
  )

  post("/v1/measurements",operation(v1MeasurementsPostOperation)) {
    
    
    bodyParam[MeasurementSet]("body").description("")
    println("body: " + body)
    
    
                val accessToken = params.getAs[String]("accessToken")

    println("accessToken: " + accessToken)
  }

  

  val v1MeasurementsRangeGetOperation = (apiOperation[MeasurementRange]("v1MeasurementsRangeGet")
      summary "Get measurements range for this user"
      parameters(queryParam[String]("sources").description("").optional,
        queryParam[Int]("user").description("").optional)
  )

  get("/v1/measurementsRange",operation(v1MeasurementsRangeGetOperation)) {
    
    
                val sources = params.getAs[String]("sources")

    println("sources: " + sources)
    
    
                val user = params.getAs[Int]("user")

    println("user: " + user)
  }

  

  val v2MeasurementsCsvGetOperation = (apiOperation[File]("v2MeasurementsCsvGet")
      summary "Get Measurements CSV"
      parameters(queryParam[String]("accessToken").description("").optional)
  )

  get("/v2/measurements/csv",operation(v2MeasurementsCsvGetOperation)) {
    
    
                val accessToken = params.getAs[String]("accessToken")

    println("accessToken: " + accessToken)
  }

  

  val v2MeasurementsIdDeleteOperation = (apiOperation[Inline_response_200_12]("v2MeasurementsIdDelete")
      summary "Delete Measurement"
      parameters(pathParam[Int]("id").description(""),
        queryParam[String]("accessToken").description("").optional)
  )

  delete("/v2/measurements/{id}",operation(v2MeasurementsIdDeleteOperation)) {
    
    
      val id = params.getOrElse("id", halt(400))
    
    println("id: " + id)
    
    
                val accessToken = params.getAs[String]("accessToken")

    println("accessToken: " + accessToken)
  }

  

  val v2MeasurementsIdGetOperation = (apiOperation[Inline_response_200_11]("v2MeasurementsIdGet")
      summary "Get Measurement"
      parameters(pathParam[Int]("id").description(""),
        queryParam[String]("accessToken").description("").optional)
  )

  get("/v2/measurements/{id}",operation(v2MeasurementsIdGetOperation)) {
    
    
      val id = params.getOrElse("id", halt(400))
    
    println("id: " + id)
    
    
                val accessToken = params.getAs[String]("accessToken")

    println("accessToken: " + accessToken)
  }

  

  val v2MeasurementsIdPutOperation = (apiOperation[Inline_response_200_12]("v2MeasurementsIdPut")
      summary "Update Measurement"
      parameters(pathParam[Int]("id").description(""),
        queryParam[String]("accessToken").description("").optional,
        bodyParam[Measurement]("body").description("").optional)
  )

  put("/v2/measurements/{id}",operation(v2MeasurementsIdPutOperation)) {
    
    
      val id = params.getOrElse("id", halt(400))
    
    println("id: " + id)
    
    
                val accessToken = params.getAs[String]("accessToken")

    println("accessToken: " + accessToken)
    
    
    bodyParam[Measurement]("body").description("").optional
    println("body: " + body)
  }

  

  val v2MeasurementsRequestCsvPostOperation = (apiOperation[Int]("v2MeasurementsRequestCsvPost")
      summary "Post Request for Measurements CSV"
      parameters(queryParam[String]("accessToken").description("").optional)
  )

  post("/v2/measurements/request_csv",operation(v2MeasurementsRequestCsvPostOperation)) {
    
    
                val accessToken = params.getAs[String]("accessToken")

    println("accessToken: " + accessToken)
  }

  

  val v2MeasurementsRequestPdfPostOperation = (apiOperation[Int]("v2MeasurementsRequestPdfPost")
      summary "Post Request for Measurements PDF"
      parameters(queryParam[String]("accessToken").description("").optional)
  )

  post("/v2/measurements/request_pdf",operation(v2MeasurementsRequestPdfPostOperation)) {
    
    
                val accessToken = params.getAs[String]("accessToken")

    println("accessToken: " + accessToken)
  }

  

  val v2MeasurementsRequestXlsPostOperation = (apiOperation[Int]("v2MeasurementsRequestXlsPost")
      summary "Post Request for Measurements XLS"
      parameters(queryParam[String]("accessToken").description("").optional)
  )

  post("/v2/measurements/request_xls",operation(v2MeasurementsRequestXlsPostOperation)) {
    
    
                val accessToken = params.getAs[String]("accessToken")

    println("accessToken: " + accessToken)
  }

}