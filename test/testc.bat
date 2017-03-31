@rmdir exe /S /Q
@rmdir out /S /Q
@rmdir src /S /Q
@rmdir debug /S /Q
@mkdir exe
@mkdir out
@mkdir src
@mkdir debug
@for %%f in (tests/*) do java -jar ../jar/Quartz.jar tests/%%f src/%%f.c > debug/%%f.debug
@for %%f in (src/*) do gcc src/%%f -o exe/%%f.exe
@cd exe
@for %%f in (*.exe) do @for /F "tokens=*" %%i in ('call %%f') DO @echo %%i > ../out/%%f.txt
