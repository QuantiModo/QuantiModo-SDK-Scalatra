package com.wordnik.client.api

import com.wordnik.client.model.Inline_response_200_5
import com.wordnik.client.model.Connector
import com.wordnik.client.model.Inline_response_200_6
import com.wordnik.client.model.Inline_response_200_2

import java.io.File

import org.scalatra.{ TypedParamSupport, ScalatraServlet }
import org.scalatra.swagger._
import org.json4s._
import org.json4s.JsonDSL._
import org.scalatra.json.{ JValueResult, JacksonJsonSupport }
import org.scalatra.servlet.{FileUploadSupport, MultipartConfig, SizeConstraintExceededException}

import scala.collection.JavaConverters._

class ConnectorApi (implicit val swagger: Swagger) extends ScalatraServlet 
    with FileUploadSupport
    with JacksonJsonSupport
    with SwaggerSupport {
  protected implicit val jsonFormats: Formats = DefaultFormats

  protected val applicationDescription: String = "ConnectorApi"
  override protected val applicationName: Option[String] = Some("Connector")

  before() {
    contentType = formats("json")
    response.headers += ("Access-Control-Allow-Origin" -> "*")
  }
  

  val connectorsGetOperation = (apiOperation[Inline_response_200_5]("connectorsGet")
      summary "Get all Connectors"
      parameters(queryParam[String]("name").description("").optional,
        queryParam[String]("displayName").description("").optional,
        queryParam[String]("image").description("").optional,
        queryParam[String]("getItUrl").description("").optional,
        queryParam[String]("shortDescription").description("").optional,
        queryParam[String]("longDescription").description("").optional,
        queryParam[Boolean]("enabled").description("").optional,
        queryParam[Boolean]("oauth").description("").optional,
        queryParam[Int]("limit").description("").optional,
        queryParam[Int]("offset").description("").optional,
        queryParam[String]("sort").description("").optional)
  )

  get("/connectors",operation(connectorsGetOperation)) {
    
    
    
        
      
      val name = params.getAs[String]("name")
            

    
    println("name: " + name)
  
    
    
        
      
      val displayName = params.getAs[String]("displayName")
            

    
    println("displayName: " + displayName)
  
    
    
        
      
      val image = params.getAs[String]("image")
            

    
    println("image: " + image)
  
    
    
        
      
      val getItUrl = params.getAs[String]("getItUrl")
            

    
    println("getItUrl: " + getItUrl)
  
    
    
        
      
      val shortDescription = params.getAs[String]("shortDescription")
            

    
    println("shortDescription: " + shortDescription)
  
    
    
        
      
      val longDescription = params.getAs[String]("longDescription")
            

    
    println("longDescription: " + longDescription)
  
    
    
        
      
      val enabled = params.getAs[Boolean]("enabled")
            

    
    println("enabled: " + enabled)
  
    
    
        
      
      val oauth = params.getAs[Boolean]("oauth")
            

    
    println("oauth: " + oauth)
  
    
    
        
      
      val limit = params.getAs[Int]("limit")
            

    
    println("limit: " + limit)
  
    
    
        
      
      val offset = params.getAs[Int]("offset")
            

    
    println("offset: " + offset)
  
    
    
        
      
      val sort = params.getAs[String]("sort")
            

    
    println("sort: " + sort)
  
  }

  

  val connectorsPostOperation = (apiOperation[Inline_response_200_6]("connectorsPost")
      summary "Store Connector"
      parameters(bodyParam[Connector]("body").description("").optional)
  )

  post("/connectors",operation(connectorsPostOperation)) {
    
    
    
                
bodyParam[Connector]("body").description("").optional
    
    println("body: " + body)
  
  }

  

  val connectorsIdGetOperation = (apiOperation[Inline_response_200_6]("connectorsIdGet")
      summary "Get Connector"
      parameters(pathParam[Int]("id").description(""))
  )

  get("/connectors/{id}",operation(connectorsIdGetOperation)) {
    
    
    
      val id = params.getOrElse("id", halt(400))
                

    
    println("id: " + id)
  
  }

  

  val connectorsIdPutOperation = (apiOperation[Inline_response_200_2]("connectorsIdPut")
      summary "Update Connector"
      parameters(pathParam[Int]("id").description(""),
        bodyParam[Connector]("body").description("").optional)
  )

  put("/connectors/{id}",operation(connectorsIdPutOperation)) {
    
    
    
      val id = params.getOrElse("id", halt(400))
                

    
    println("id: " + id)
  
    
    
                
bodyParam[Connector]("body").description("").optional
    
    println("body: " + body)
  
  }

  

  val connectorsIdDeleteOperation = (apiOperation[Inline_response_200_2]("connectorsIdDelete")
      summary "Delete Connector"
      parameters(pathParam[Int]("id").description(""))
  )

  delete("/connectors/{id}",operation(connectorsIdDeleteOperation)) {
    
    
    
      val id = params.getOrElse("id", halt(400))
                

    
    println("id: " + id)
  
  }

}