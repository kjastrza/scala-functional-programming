import scala.math.signum
val value = (("Oracle") map (x => x compare _) zip "Geecon") map (t=> t._1(t._2)) map (signum _)
println ((value map(_ toString)))


println (value.foldLeft("")(_ + _))

println ((value map(_ toString)).foldLeft("")(_ + _))



("Oracle") map (x => x compare _) zip "Geecon"
("Oracle") map (x => x compare _) zip "Geecon" map (t => t._1(t._2))
"O" compare "G"
"r" compare "e"
"a" compare "e"
"c" compare "c"
"l" compare "o"
"e" compare "n"

