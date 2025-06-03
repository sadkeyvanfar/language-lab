use ExtUtils::MakeMaker;

WriteMakefile(
    NAME         => 'Core',
    VERSION_FROM => 'lib/Core.pm', # if you add a $VERSION later
    AUTHOR       => 'Saeid Keyvanfar',
    LICENSE      => 'perl',
    PREREQ_PM    => {},
);
