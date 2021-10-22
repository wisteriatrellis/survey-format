package com.survey.format

import scala.util.parsing.combinator._


object SurveyParser extends RegexParsers {
  def section = """\section{""" ~ """[^\}]*""".r ~ """}""" ^^ {
    case x ~ y ~ z => x + y + z
  }

  def allSpace = """[\s]*""".r ^^ (_ => "space")
  //def frame = """\begin{frame}""" ~ allSpace ~ blocks ~ allSpace ~ """\end{frame}""" //rep(frame)
  //def blockCount = 3
  //def blocks = block(1) ~ block(2) ~ block3 ^^ {
  //  case f1 ~ f2 ~ f3 => f1 + f2 + f3
  //}
  //// latexの方で
  //// section, subsectionがなくてもframe, blockが有効なことの確認
  //// blockのタイトル無しの場合の確認
  //// section, subsectionのパーサをframe, blockのパーサと交換
  //def block(n: Int) =
  //  subsection((title(n))) ~ raw"[^(\\subsection\{${title(n + 1)}\})]*".r ^^ {
  //    case mark ~ body => mark + body
  //  }
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
    println(parseAll(section, """\section{Hello}""").get)
  }
}
