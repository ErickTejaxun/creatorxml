SET JFLEX_HOME=C:\libs\jflex-1.7.0\lib
cd C:\Users\erick\Documents\NetBeansProjects\CreatorXML_201213050\src\Analisis\Gdato
java -jar %JFLEX_HOME%\jflex-full-1.7.0.jar scannergd.flex
pause

SET CUP_HOME= C:\libs
cd C:\Users\erick\Documents\NetBeansProjects\CreatorXML_201213050\src\Analisis\Gdato
java -jar %CUP_HOME%\java-cup-11b.jar -parser parsergd parsergd.cup
pause