#!/bin/bash

DIR_PATH=`pwd`		# varsayılan olarak çalıştırıldığı dizinden başla
FILE_FORMAT="txt"	# varsayılan olarak txt uzantıları seç
N_DAYS=30		# 30 gün öncesinden başla

while getopts ":p:d:f" opt; do
	case $opt in
		p)
			DIR_PATH=$OPTARG
			;;
		d)
			N_DAYS=$OPTARG
			;;
		f)
			FILE_FORMAT=$OPTARG
			;;
		\?)
			echo "Invalid option: -$OPTARG" >&2
			exit 1
			;;
		:)
			echo "Option -$OPTARG requires an argument." >&2
			exit 1
			;;
	esac
done

echo "logların silineceği dizin: $DIR_PATH"
echo "silinecek log dosya formatı: $FILE_FORMAT"
echo "$N_DAYS gün öncesinden başlanacak..."

function run_process()
{
	local mon=$[ $N_DAYS*24*60*60 ]
	local i=1

	for file in $( find $DIR_PATH -type f -name "*.$FILE_FORMAT" ); do
		if [ -f $file ]; then
			local mod_secs=$(date --utc --reference=$file +%s)
			local now_secs=$(date +%s)
			local delta=$[ $now_secs-$mod_secs ]
			local day=$[ $delta/(24*60*60) ]

			if [ $delta -lt $mon ]; then
				echo $file " -> modification $day day ago..."
			else
				rm $file
				echo "INFO [deleted...] file: $file - last modifided day: $day"
			fi
		fi
	done
}

read -p "$DIR_PATH dizinindeki $FILE_FORMAT formatındaki tüm loglar silinecek.
Devam edilsin mi? (e/h): " CONT

if [ "$CONT" == "e" ]; then
	run_process
else
	exit 0
fi
