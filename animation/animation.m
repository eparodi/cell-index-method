function animation(static_file, dynamic_file, output_file, m, particle)
  fileID = fopen(static_file,'r');
  N = str2num(fgetl(fileID));
  L = str2num(fgetl(fileID));
  fclose(fileID);
  [radius colour] = textread(static_file,"%f %f", 'headerLines', 2);
  [x y] = textread(dynamic_file,"%f %f", 'headerLines', 1);
  fileID = fopen(output_file,'r');
  fgetl(fileID); %Header line
  neighbour={};
  for i = 1:N
    line = fgetl(fileID);
    neighbour{end+1} = textscan(line,'%d');
  end
  plot = scatter(x,y,'b','filled');
  title('Index Cell Method');
  xlabel('X position');
  ylabel('Y position');
  hold on;
  queryX = x(particle);
  queryY = y(particle);
  plot = scatter(queryX,queryY,'g', 'filled');
  highlighted = neighbour{particle}{1}(2:end);
  queryX1 = x(highlighted);
  queryY1 = y(highlighted);
  plot = scatter(queryX1,queryY1,'r', 'filled');
  set(gca,'xtick',[0:(L/m):L]);
  set(gca,'ytick',[0:(L/m):L]);
  grid on;
endfunction