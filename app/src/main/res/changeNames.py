import os


for dir in os.listdir('.'):
	#print(dir +"----")
	if os.path.isdir(dir):
		for file in os.listdir('./'+dir):
			#if '-' in file:
				#print(file)
			newfilename = file.lower()
			print(file + "--->" + newfilename)
			os.rename("./" + dir + "/" + file,"./"+ dir + "/" + newfilename)
