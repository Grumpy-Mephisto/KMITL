#!/usr/bin/env bash

start_num=1
end_num=11

for ((i = $start_num; i <= $end_num; i++)); do
    original_script="q$i.sh"
    obfuscated_content=$(cat "$original_script" | base64)
    obfuscated_script="${original_script}.obfuscated"
    
    echo "#!/usr/bin/env bash" > "$obfuscated_script"
    echo "echo 'This is an obfuscated script (q$i.sh)!'" >> "$obfuscated_script"
    echo "echo 'Decoding and executing original script...'" >> "$obfuscated_script"
    echo "echo '$obfuscated_content' | base64 -d | bash" >> "$obfuscated_script"
    chmod +x "$obfuscated_script"
    
    echo "Obfuscation complete. Obfuscated script saved as: $obfuscated_script"
done
