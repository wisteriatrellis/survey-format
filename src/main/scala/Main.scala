package com.survey.format

import scala.util.parsing.combinator._


object SurveyParser extends RegexParsers {
  def section = """\\section\{[\s\S]*\}""".r

  def allSpace = """[\s]*""".r ^^ (_ => "\n")
  //def frame = """\begin{frame}""" ~ allSpace ~ blocks ~ allSpace ~ """\end{frame}""" //rep(frame)
  //def blockCount = 3
  //def blocks = block(1) ~ block(2) ~ block3 ^^ {
  //  case f1 ~ f2 ~ f3 => f1 + f2 + f3
  //}
  //// latexの方で
  //// section, subsectionがなくてもframe, blockが有効なことの確認
  //// blockのタイトル無しの場合の確認
  //// section, subsectionのパーサをframe, blockのパーサと交換
  def block =
     """\\begin\{block\}\{1\}[\s\S]*\\end\{block\}""".r 
  //def block3 = subsection(title(3))
  ////def subsection1 = raw"\\subsection\{$title\}".r
  //def subsection(title: String) = """\subsection{""" ~ title ~  """}""" ^^ {
  //  case _  ~ title ~ _ => raw"\block{$title}"
  //}
  //def title: Map[Int, String] = Map(
  //  1 -> "111",
  //  2 -> "222",
  //  3 -> "333",
  //)
  //def parse( input: String ) = parseAll(reg, input )
}


object Main {
  import SurveyParser._
  def main(args: Array[String]): Unit = {
    val input = """\begin{block}{1}
      Hello World
    \end{block}"""
    val output = parseAll(block, input).get
    println(output)
  }
}
