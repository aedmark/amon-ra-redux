;;; Sierra Script 1.0 - (do not remove this comment)
(script# 455)
(include sci.sh)
(use Main)
(use LBRoom)
(use Inset)
(use CueObj)
(use n958)
(use Sound)
(use Cycle)
(use View)
(use Obj)

(public
	rm455 0
)

(instance rm455 of LBRoom
	(properties
		sel_20 {rm455}
		sel_408 555
	)
	
	(method (sel_110)
		(proc958_0 128 470 563)
		(proc958_0 132 6)
		(super sel_110:)
		(gGame sel_87: 1 134)
		(self sel_146: sFindPippin)
	)
	
	(method (sel_111)
		(screamAndLook sel_170: 0 12 30 1)
		(super sel_111:)
	)
	
	(method (sel_300 param1)
		(switch param1
			(13 (sFindPippin sel_145:))
			(else  (super sel_300: param1))
		)
	)
	
	(method (sel_399 param1)
		(proc0_8 0)
		(screamAndLook sel_170: 0 12 30 1)
		(wrapMusic sel_111: 1)
		(super sel_399: param1)
	)
)

(instance sFindPippin of Script
	(properties
		sel_20 {sFindPippin}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGameMusic2 sel_40: 82 sel_99: 5 sel_3: 1 sel_39:)
				(wrapMusic sel_110: -1 1 6)
				(= sel_137 3)
			)
			(1
				(gGame sel_588:)
				(proc0_8 1)
				(global2 sel_417: 470)
				(global2 sel_408: 470)
				(drip sel_110: sel_161: Fwd)
				(pipMummy sel_110:)
				(leftEye sel_110:)
				(rightEye sel_110:)
				(nose sel_110:)
				(moustache sel_110:)
				(mouthOpen sel_110:)
				(ear sel_110:)
				(hair sel_110:)
				(dagger sel_110:)
				(jacket sel_110:)
				(pants sel_110:)
				(vest sel_110:)
				(flesh sel_110:)
				(shirt sel_110:)
				(flower sel_110:)
			)
			(2 (global2 sel_399: 454))
		)
	)
)

(instance drip of Prop
	(properties
		sel_20 {drip}
		sel_1 180
		sel_0 100
		sel_213 2
		sel_2 470
	)
	
	(method (sel_300 param1)
		(switch param1
			(13 (sFindPippin sel_145:))
			(else  (super sel_300: param1))
		)
	)
)

(instance pipMummy of Feature
	(properties
		sel_20 {pipMummy}
		sel_1 1
		sel_0 1
		sel_213 13
		sel_302 -32768
	)
	
	(method (sel_300 param1)
		(switch param1
			(13 (sFindPippin sel_145:))
			(else  (super sel_300: param1))
		)
	)
)

(instance leftEye of Feature
	(properties
		sel_20 {leftEye}
		sel_1 1
		sel_0 1
		sel_213 14
		sel_302 2
	)
	
	(method (sel_300 param1)
		(switch param1
			(13 (sFindPippin sel_145:))
			(else  (super sel_300: param1))
		)
	)
)

(instance rightEye of Feature
	(properties
		sel_20 {rightEye}
		sel_1 1
		sel_0 1
		sel_213 8
		sel_302 4
	)
	
	(method (sel_300 param1)
		(switch param1
			(13 (sFindPippin sel_145:))
			(else  (super sel_300: param1))
		)
	)
)

(instance nose of Feature
	(properties
		sel_20 {nose}
		sel_1 1
		sel_0 1
		sel_213 11
		sel_302 8
	)
	
	(method (sel_300 param1)
		(switch param1
			(13 (sFindPippin sel_145:))
			(else  (super sel_300: param1))
		)
	)
)

(instance moustache of Feature
	(properties
		sel_20 {moustache}
		sel_1 1
		sel_0 1
		sel_213 9
		sel_302 16
	)
	
	(method (sel_300 param1)
		(switch param1
			(13 (sFindPippin sel_145:))
			(else  (super sel_300: param1))
		)
	)
)

(instance mouthOpen of Feature
	(properties
		sel_20 {mouthOpen}
		sel_1 1
		sel_0 1
		sel_213 10
		sel_302 32
	)
	
	(method (sel_300 param1)
		(switch param1
			(13 (sFindPippin sel_145:))
			(else  (super sel_300: param1))
		)
	)
)

(instance ear of Feature
	(properties
		sel_20 {ear}
		sel_1 1
		sel_0 1
		sel_213 3
		sel_302 64
	)
	
	(method (sel_300 param1)
		(switch param1
			(13 (sFindPippin sel_145:))
			(else  (super sel_300: param1))
		)
	)
)

(instance hair of Feature
	(properties
		sel_20 {hair}
		sel_1 1
		sel_0 1
		sel_213 6
		sel_302 128
	)
	
	(method (sel_300 param1)
		(switch param1
			(13 (sFindPippin sel_145:))
			(else  (super sel_300: param1))
		)
	)
)

(instance dagger of Feature
	(properties
		sel_20 {dagger}
		sel_1 1
		sel_0 1
		sel_213 1
		sel_302 256
	)
	
	(method (sel_300 param1)
		(switch param1
			(13 (sFindPippin sel_145:))
			(else  (super sel_300: param1))
		)
	)
)

(instance jacket of Feature
	(properties
		sel_20 {jacket}
		sel_1 1
		sel_0 1
		sel_213 7
		sel_302 512
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(if (gEgo sel_238: 21)
					(gLb2Messager sel_295: 7 1 2)
				else
					(gLb2Messager sel_295: 7 1 1)
				)
			)
			(8
				(if (gEgo sel_238: 21)
					(gLb2Messager sel_295: 7 8 2)
				else
					(gLb2Messager sel_295: 7 8 1)
				)
			)
			(4
				(if (gEgo sel_238: 21)
					(gLb2Messager sel_295: 7 4 2)
				else
					(global2 sel_422: inNotepad)
				)
			)
			(13 (sFindPippin sel_145:))
			(else  (super sel_300: param1))
		)
	)
)

(instance pants of Feature
	(properties
		sel_20 {pants}
		sel_1 1
		sel_0 1
		sel_213 12
		sel_302 1024
	)
	
	(method (sel_300 param1)
		(switch param1
			(13 (sFindPippin sel_145:))
			(else  (super sel_300: param1))
		)
	)
)

(instance vest of Feature
	(properties
		sel_20 {vest}
		sel_1 1
		sel_0 1
		sel_213 16
		sel_302 2048
	)
	
	(method (sel_300 param1)
		(switch param1
			(13 (sFindPippin sel_145:))
			(else  (super sel_300: param1))
		)
	)
)

(instance flesh of Feature
	(properties
		sel_20 {flesh}
		sel_1 1
		sel_0 1
		sel_213 4
		sel_302 4096
	)
	
	(method (sel_300 param1)
		(switch param1
			(13 (sFindPippin sel_145:))
			(else  (super sel_300: param1))
		)
	)
)

(instance shirt of Feature
	(properties
		sel_20 {shirt}
		sel_1 1
		sel_0 1
		sel_213 15
		sel_302 8192
	)
	
	(method (sel_300 param1)
		(switch param1
			(13 (sFindPippin sel_145:))
			(else  (super sel_300: param1))
		)
	)
)

(instance flower of Feature
	(properties
		sel_20 {flower}
		sel_1 1
		sel_0 1
		sel_213 5
		sel_302 16384
	)
	
	(method (sel_300 param1)
		(switch param1
			(13 (sFindPippin sel_145:))
			(else  (super sel_300: param1))
		)
	)
)

(instance inNotepad of Inset
	(properties
		sel_20 {inNotepad}
		sel_2 563
		sel_3 2
		sel_4 2
		sel_1 118
		sel_0 79
		sel_570 1
	)
	
	(method (sel_110)
		(super sel_110: &rest)
		(gLb2Messager sel_295: 7 4 1)
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(self sel_111:)
				(gGame sel_87: 1 135)
				((ScriptID 21 0) sel_57: 790)
				(gEgo sel_350: 21)
			)
			(1
				(gLb2Messager sel_295: 45 1 0 0 0 15)
			)
			(8
				(gLb2Messager sel_295: 45 8 0 0 0 15)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance wrapMusic of WrapMusic
	(properties
		sel_20 {wrapMusic}
	)
	
	(method (sel_110)
		(= sel_608 screamAndLook)
		(super sel_110: &rest)
	)
)

(instance screamAndLook of Sound
	(properties
		sel_20 {screamAndLook}
	)
)
