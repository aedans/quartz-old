@rmdir exe /S /Q
@rmdir out /S /Q
@rmdir src /S /Q
@mkdir exe
@mkdir out
@mkdir src
java -jar ../jar/Quartz.jar tests src > debug.txt
@for %%f in (src/*) do nvcc src/%%f -o exe/%%f.exe --machine 32 -x cu --optimize 0 -Wno-deprecated-gpu-targets --cudart shared
@cd exe
@for %%f in (*.exe) do @for /F "tokens=*" %%i in ('call %%f') DO @echo %%i > ../out/%%f.txt
