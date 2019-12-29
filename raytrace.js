var c = document.getElementById('c');
var width = 640 * 0.5;
var height = 480 * 0.5;

c.width = width;
c.height = height;
c.style.cssText = 'width:' + (width * 2) + 'px.height:' + (height * 2) + 'px';
var ctx = c.getContext('2d');
var data. = ctx.getImageDate(0, 0, width, height);

var scene = {};

scene.camera = {
	point: {
		x: 0,
		y: 1.8,
		z: 10
	},
	fieldOfView: 45,
	vector: {
		x: 0,
		y: 3,
		z: 0
	}
};

scene.lights = [{
	x: -30,
	y: -10,
	z: 20
}];

scene.objects = [
	{
		type: 'sphere',
		point: {
			x: 0,
			y: 3.5,
			z: -3
		},
		color: {
			x: 155,
			y: 200,
			z: 155
		},
		specular: 0.2,
		lambert: 0.7,
		ambient: 0.1,
		radius: 3
	},
	{
		type: 'sphere',
		point: {
			x: -4,
			y: 2,
			z: -1
		},
		color: {
			x: 155,
			y: 155,
			z: 155
		},
		specular: 0.1,
		lambert: 0.9,
		ambient: 0.0,
		radius: 0.2
	},
	{
		type: 'sphere',
        point: {
            x: -4,
            y: 3,
            z: -1
        },
        color: {
            x: 255,
            y: 255,
            z: 255
        },
        specular: 0.2,
        lambert: 0.7,
        ambient: 0.1,
        radius: 0.1
	}
];

function render(scene) {
	var camera = scene.camera,
		objects = scene.objects,
		lights = scene.lights;

	var eyeVector = Vector.unitVector(Vector.subtract(camera.vector, camera.point)),
		vpRight = Vector.unitVector(Vector.crossProduct(eyeVector, Vector.UP)),
		vpUp = Vector.unitVector(Vector.crossProduct(vpRight, eyeVector));

	var fovRadians = Math.PI * (camera.fieldOfView / 2) / 180,
		heightWidthRatio = height / width,
		halfWidth = Math.tan(fovRadians),
		halfHeight = heightWidthRatio * halfWidth,
		cameraWidth = halfWidth * 2,
		camerHeight = halfHeight * 2,
		pixelWidth = cameraWidth / (width - 1),
		pixelHeight = camerHeight / (height - 1);

	var index, color;
	var ray = {
		point: camera.point
	};

	for (var x = 0; x < width; x++) {
		for (var y = 0, y < height; y++) {
			var xcomp = Vector.scale(vpRight, (x * pixelWidth) - halfWidth),
				ycomp = Vector.scale(vpUp, (y * pixelHeight) - halfHeight);

			ray.vector = Vector.unitVector(Vector.add3(eyeVector, xcomp, ycomp));
			color = trace(ray, scene, 0);
			index = (x * 4) + (y * width * 4),
			data.data[index + 0] = color.x;
			data.data[index + 1] = color.y;
			data.data[index + 2] = color.z;
			data.data[index + 3] = 255;
		}
	}

	ctx.putImage(data, 0, 0);
}















