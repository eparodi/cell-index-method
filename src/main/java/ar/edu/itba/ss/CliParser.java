package ar.edu.itba.ss;

import org.apache.commons.cli.*;

public class CliParser {

    public static String staticFile;
    public static String dynamicFile;
    public static int matrixSize;
    public static double interactionRadius;
    public static boolean periodicContour;

    private static Options createOptions(){
        Options options = new Options();
        options.addOption("h", "help", false, "Shows this screen.");
        options.addOption("m","matrix", true, "Size of the squared matrix.");
        options.addOption("rc", "radius", true, "Radius of interaction between particles.");
        options.addOption("sf", "static_file", true, "Path to the file with the static values.");
        options.addOption("df", "dynamic_file", true, "Path to the file with the dynamic values.");
        options.addOption("pc", "periodic_contour", false, "Enables periodic contour conditions.");
        return options;
    }

    public static void parseOptions(String[] args){
        Options options = createOptions();
        CommandLineParser parser = new BasicParser();

        try{
            CommandLine cmd = parser.parse(options, args);
            if(cmd.hasOption("h")){
                help(options);
            }
            if (!cmd.hasOption("df") || !cmd.hasOption("sf")){
                System.out.println("You must specify a static file and a dynamic file!");
                System.exit(1);
            }

            dynamicFile = cmd.getOptionValue("df");
            staticFile = cmd.getOptionValue("sf");

            if (cmd.hasOption("m")){
                matrixSize = Integer.parseInt(cmd.getOptionValue("m"));
            }
            if (cmd.hasOption("rc")){
                interactionRadius = Double.parseDouble(cmd.getOptionValue("rc"));
            }
            if (cmd.hasOption("pc")){
                periodicContour = true;
            }

        }catch (Exception e){
            System.out.println("Command not recognized.");
            help(options);
        }
    }

    private static void help(Options options){
        HelpFormatter helpFormatter = new HelpFormatter();
        helpFormatter.printHelp("Main", options);
        System.exit(0);
    }
}
