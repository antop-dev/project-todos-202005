const protocol: string = 'http';
const port: number = 8080;
const host: string = window.location.hostname;
const uri: string = host + ':' + port;

export default function (path: string) {
    return protocol + '://' + uri + path;
}
