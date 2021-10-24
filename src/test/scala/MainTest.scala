package com.survey.format

import org.scalatest.funsuite.AnyFunSuite
 

class SurveyParserTest extends AnyFunSuite {
  import SurveyParser._

  test("section test") {
    val input = """\section{Hello}"""
    val output = parseAll(section, input).get
    val correct = """\section{Hello}"""
    assert(output === correct)
  }

  test("allSpace test") {
    val input = """    
           
    """
    val output = parseAll(allSpace, input).get
    val correct = "\n"
    assert(output === correct)
  }

  test("block test") {
    val input = """\begin{block}{1}
      Hello World 
    \end{block}"""
    val output = parseAll(block, input).get
    println(input)
    println(output)
    val correct = input
    assert(output === correct)
  }
}
