provider "aws" {
  region = "ap-south-1a"
}

resource "aws_key_pair" "default" {
  key_name   = "ToDoAppKey"
  public_key = file("~/.ssh/id_rsa.pub")
}

resource "aws_instance" "web" {
  ami           = "ami-0dee22c13ea7a9a67" 
  instance_type = "t2.micro"
  key_name      = aws_key_pair.default.key_name 

  tags = {
    Name = "ToDoAppServer"
  }

  provisioner "remote-exec" {
    inline = [
      "sudo apt update",
      "sudo apt install -y docker.io",
      "sudo usermod -aG docker ubuntu",
      "sudo systemctl start docker"
    ]
    connection {
      type        = "ssh"
      user        = "ubuntu"
      private_key = file("~/.ssh/id_rsa")
      host        = self.public_ip
    }
  }
}
