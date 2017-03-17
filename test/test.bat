@rmdir debug /S /Q
@rmdir exe /S /Q
@rmdir out /S /Q
@rmdir src /S /Q
@mkdir debug
@mkdir exe
@mkdir out
@mkdir src
for %%f in (tests/*) do java -jar ../Quartz.jar ./tests/%%f ./src 1> debug/%%f.txt
for %%f in (src/*) do gcc src/%%f -o exe/%%f.exe
cd exe
for %%f in (*.*) do for /F "tokens=*" %%i in ('call %%f "test"') DO echo %%i > ../out/%%f.txt
