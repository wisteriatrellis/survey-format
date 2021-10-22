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
}
