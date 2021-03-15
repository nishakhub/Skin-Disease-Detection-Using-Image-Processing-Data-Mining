<?php
/**
 * Transfer Files Server to Server using PHP Copy
 * @link https://shellcreeper.com/?p=1249
 */

/* Source File URL */
$remote_file_url = 'http://192.168.43.122/upload/assets';

/* New file name and path for this file */
$local_file = 'http://localhost/files';

/* Copy the file from source url to server */
$copy = copy( $remote_file_url, $local_file );

/* Add notice for success/failure */
if( !$copy ) {
    echo "Doh! failed to copy $file...\n";
}
else{
    echo "WOOT! success to copy $file...\n";
}
?>