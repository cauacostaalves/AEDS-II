using System;
using System.IO;

class teste
{
    static void Main()
    {
        // Caminho do arquivo
        string filePath = "exemplo.txt";

        // Dados que queremos escrever no arquivo
        string[] lines = {
            "Linha 1: Olá, mundo!",
            "Linha 2: Bem-vindo ao C#",
            "Linha 3: Escrevendo em um arquivo."
        };

        // Usando StreamWriter para criar e escrever no arquivo
        try
        {
            using (StreamWriter writer = new StreamWriter(filePath))
            {
                foreach (string line in lines)
                {
                    writer.WriteLine(line);
                }
            }

            Console.WriteLine("Arquivo criado e escrito com sucesso!");
        }
        catch (Exception ex)
        {
            Console.WriteLine("Ocorreu um erro: " + ex.Message);
        }
    }
}
