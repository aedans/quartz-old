@rmdir exe /S /Q
@rmdir out /S /Q
@rmdir src /S /Q
@mkdir exe
@mkdir out
@mkdir src
java -jar ../Quartz.jar ./tests ./src > debug.txt
@for %%f in (src/*) do gcc src/%%f -o exe/%%f.exe
cd exe
@for %%f in (*.*) do @for /F "tokens=*" %%i in ('call %%f') DO @echo %%i > ../out/%%f.txt
